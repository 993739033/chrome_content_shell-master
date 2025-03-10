// Copyright 2019 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.base.supplier;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.Objects;
import org.chromium.base.Callback;
import org.chromium.base.ObserverList;
import org.chromium.base.ResettersForTesting;

/**
 * Concrete implementation of {@link ObservableSupplier} to be used by classes owning the
 * ObservableSupplier and providing it as a dependency to others.
 *
 * <p>This class must only be accessed from a single thread.
 *
 * <p>To use: 1. Create a new ObservableSupplierImpl<E> to pass as a dependency 2. Call {@link
 * #set(Object)} when the real object becomes available. {@link #set(Object)} may be called multiple
 * times. Observers will be notified each time a new object is set.
 *
 * @param <E> The type of the wrapped object.
 */
public class ObservableSupplierImpl<E> implements ObservableSupplier<E> {
  private static boolean sIgnoreThreadChecksForTesting;

  private final Thread mThread = Thread.currentThread();
  private final Handler mHandler = new Handler();

  private E mObject;
  private final ObserverList<Callback<E>> mObservers = new ObserverList<>();

  public ObservableSupplierImpl() {}

  public ObservableSupplierImpl(E initialValue) {
    mObject = initialValue;
  }

  @Override
  public E addObserver(Callback<E> obs) {
    checkThread();
    mObservers.addObserver(obs);

    if (mObject != null) {
      final E currentObject = mObject;
      mHandler.post(
          () -> {
            if (mObject != currentObject || !mObservers.hasObserver(obs)) return;
            obs.onResult(mObject);
          });
    }

    return mObject;
  }

  @Override
  public void removeObserver(Callback<E> obs) {
    checkThread();
    mObservers.removeObserver(obs);
  }

  /**
   * Set the object supplied by this supplier. This will notify registered callbacks that the
   * dependency is available if the object changes. Object equality is used when deciding if the
   * object has changed, not reference equality.
   *
   * @param object The object to supply.
   */
  public void set(E object) {
    checkThread();
    if (Objects.equals(object, mObject)) {
      return;
    }

    mObject = object;

    for (Callback<E> observer : mObservers) {
      observer.onResult(mObject);
    }
  }

  @Override
  public @Nullable E get() {
    checkThread();
    return mObject;
  }

  /** Returns if there are any observers currently. */
  public boolean hasObservers() {
    return !mObservers.isEmpty();
  }

  private void checkThread() {
    assert sIgnoreThreadChecksForTesting || mThread == Thread.currentThread()
        : "ObservableSupplierImpl must only be used on a single Thread.";
  }

  /** Used to allow developers to access supplier values on the instrumentation thread. */
  public static void setIgnoreThreadChecksForTesting(boolean ignoreThreadChecks) {
    sIgnoreThreadChecksForTesting = ignoreThreadChecks;
    ResettersForTesting.register(() -> sIgnoreThreadChecksForTesting = false);
  }
}
