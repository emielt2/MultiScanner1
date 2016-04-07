package com.ETMS1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.Description;
import org.junit.rules.TestWatcher;
public class positive {
    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e,Description d) {
            System.out.println("FAILED: "+d.getClassName()+"."+d.getMethodName());
        }

        @Override
        protected void succeeded(Description d) {
            System.out.println("PASSED: "+d.getClassName()+"."+d.getMethodName());
        }
    };

    @Test
    public void fails() {
        Assert.fail("I am a failure");
    }

    @Test
    public void passes() {
    }
}