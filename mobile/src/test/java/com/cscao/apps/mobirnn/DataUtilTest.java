package com.cscao.apps.mobirnn;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by qqcao on 4/5/17Wednesday.
 *
 * Test weights parsing
 */
public class DataUtilTest {

    @Test
    public void parseBias() throws Exception {
        float[] biases =
                {6.430978178977966309e-01f, 1.422856748104095459e-01f,
                        1.947010159492492676e+00f, -1.941539049148559570e-01f,
                        1.498547315597534180e+00f, 3.788197934627532959e-01f,
                        7.266948223114013672e-01f, -1.020129695534706116e-01f,
                        5.147905349731445312e-01f, 9.793586134910583496e-01f};
        String testFilePath = getClass().getClassLoader().getResource("b_in.csv").getFile();

        assertTrue(Arrays.equals(DataUtil.parseBias(testFilePath), biases));

    }

    @Test
    public void parseWeight() throws Exception {

        float[][] weights =
                {{1.302366554737091064e-01f, 8.976213634014129639e-02f, -3.018706291913986206e-02f},
                        {-1.279512979090213776e-02f, -9.628687798976898193e-02f,
                                1.115116998553276062e-01f},
                        {-1.271081268787384033e-01f, -7.517708837985992432e-02f,
                                7.937213778495788574e-02f},
                        {3.289928138256072998e-01f, -6.845261901617050171e-02f,
                                9.846886992454528809e-01f}};

        String testFilePath = getClass().getClassLoader().getResource("w_in.csv").getFile();

        assertTrue(Arrays.deepEquals(DataUtil.parseWeight(testFilePath), weights));
    }

    @Test
    public void parseInputData() throws Exception {
        float[][][] data = {{{1.1653150e-002f, -2.9399040e-002f, 4.3746370e-001f, 5.3134920e-001f},
                {1.3109090e-002f, -3.9728670e-002f, 4.6826410e-001f, 7.2106850e-001f},
                {1.1268850e-002f, -5.2405860e-002f, 4.9825740e-001f, 5.2032840e-001f}},
                {{2.7830730e-002f, -5.2106230e-002f, 4.7939570e-001f, 3.7262520e-001f},
                        {2.3183500e-003f, -4.5470360e-002f, 3.8989350e-001f, 4.1454140e-001f},
                        {-1.8965500e-002f, -3.7763610e-002f, 3.0665100e-001f, 3.3332790e-001f}}};
        String testFilePath = getClass().getClassLoader().getResource("sensor_data").getFile();
        assertTrue(Arrays.deepEquals(DataUtil.parseInputData(testFilePath), data));
    }

    @Test
    public void parseLabel() throws Exception {
        int[] labels = {5, 4, 3, 2};
        String testFilePath = getClass().getClassLoader().getResource("y_test.txt").getFile();
        assertTrue(Arrays.equals(DataUtil.parseLabel(testFilePath), labels));
    }
}