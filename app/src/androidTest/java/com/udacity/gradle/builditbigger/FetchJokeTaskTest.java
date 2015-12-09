package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;

/**
 * Created by DS on 12/6/2015.
 */
public class FetchJokeTaskTest extends AndroidTestCase implements FetchJokeTask.OnTaskCompleted{

// Reference:
// http://blog.zadorozhnyi.com/2012/06/19/unit-testing-asynctask-descendants/

    final CountDownLatch signal = new CountDownLatch(1);

    public void testFetchJokeTask()throws InterruptedException{
        final FetchJokeTask fetchJokeTask = new FetchJokeTask(this);
        fetchJokeTask.execute();
        signal.await();
    }

    @Override
    public void onTaskCompleted(String joke) {
        assertNotNull(joke);
        assertTrue(joke.length()>0);
        signal.countDown();
    }
}