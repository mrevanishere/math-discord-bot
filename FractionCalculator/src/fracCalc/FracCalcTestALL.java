package fracCalc;

import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// To run all tests, just click somewhere inside this file, and click the Play button
// The results will appear categorized by checkpoint.  Your code should pass
// all tests for the checkpoint you're submitting AND ALL PRIOR CHECKPOINTS

@RunWith(Suite.class)
@Suite.SuiteClasses({
    FracCalcTestCheckpoint1.class,
    FracCalcTestCheckpoint2.class,
    FracCalcTestCheckpoint3.class,
    FracCalcTestFinal.class,
})

public class FracCalcTestALL
{
    public static void assertForEarlyCheckpoints(String answer1, String answer2, String answer3, String candidate)
    {
        if (candidate == null)
        {
            System.err.println("FAILURE: Your calculator returned a null string");
            assertEquals("See console window for failure info", true, false);
            return;
        }
        
        // Candidate must match answer1, answer2, or must reduce to answer3
        if (answer1 != null && candidate.equals(answer1))
        {
            // Passed
            return;
        }
        if (answer2 != null && candidate.equals(answer2))
        {
            // Passed
            return;
        }
        if (answer3 != null && FracCalcTestHelper.areFracsEqual(answer3, candidate))
        {
            // Passed
            return;
        }
        
        System.err.println("FAILURE: Your calculator's answer: '" + candidate + "' did not match the expected answer(s) below");
        if (answer1 != null)
        {
            System.err.println("Checkpoint 1: Expected: '" + answer1 + "'");
        }
        if (answer2 != null)
        {
            System.err.println("Checkpoint 2: Expected: '" + answer2 + "'");
        }
        if (answer3 != null)
        {
            System.err.println("Checkpoint 3: Expected any answer that is equivalent to: '" + answer3 + "'\n    For checkpoint 3, your answer need not be reduced, but it must be equivalent to the expected answer.");
        }

        assertEquals("See console window for failure info", true, false);
    }
}

