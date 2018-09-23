package eus.ehu.ikasle.eda;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    private Main main;

    @Before
    public void setUp() throws Exception {
        main = new Main();
    }

    @After
    public void tearDown() throws Exception {
        main = null;
    }

    @Test
    public void main() {
        Main.main(null);
    }
}