package org.jfree.data.test.suite;


import org.jfree.data.test.cases.range.RangeCombineTest;
import org.jfree.data.test.cases.range.RangeContainsTest;
import org.jfree.data.test.cases.range.RangeEqualTest;
import org.jfree.data.test.cases.range.RangeExpandTest;
import org.jfree.data.test.cases.range.RangeGetLengthTest;
import org.jfree.data.test.cases.utilities.UtilitiesCalculateColumnTotal;
import org.jfree.data.test.cases.utilities.UtilitiesCalculateRowTotal;
import org.jfree.data.test.cases.utilities.UtilitiesCreateNumberArray;
import org.jfree.data.test.cases.utilities.UtilitiesCreateNumberArray2D;
import org.jfree.data.test.cases.utilities.UtilitiesGetCumulativePercentages;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ RangeCombineTest.class, RangeContainsTest.class, RangeEqualTest.class, RangeExpandTest.class, RangeGetLengthTest.class, 
	UtilitiesCalculateColumnTotal.class, UtilitiesCalculateRowTotal.class, UtilitiesCreateNumberArray.class, UtilitiesCreateNumberArray2D.class,
	UtilitiesGetCumulativePercentages.class})
public class Assignment2Tests {

}
