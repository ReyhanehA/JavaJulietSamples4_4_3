/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE617_Reachable_Assertion__Environment_19.java
Label Definition File: CWE617_Reachable_Assertion.label.xml
Template File: sources-sink-19.tmpl.java
*/
/*
* @description
* CWE: 617 Assertion is reachable
* BadSource: Environment Read a string from an environment variable
* GoodSource: A hardcoded string
* BadSink:  possibility of assertion being triggered
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE617_Reachable_Assertion;

import testcasesupport.*;

import javax.servlet.http.*;

import java.util.logging.Logger;

public class CWE617_Reachable_Assertion__Environment_19 extends AbstractTestCase
{

    /* uses badsource and badsink */
    public void bad() throws Throwable
    {
        String data;
        {

            Logger log_bad = Logger.getLogger("local-logger");

            /* get environment variable ADD */
            data = System.getenv("ADD");

            /* POTENTIAL FLAW: assertion is evaluated */
            assert data.length() > 0;

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

            /* POTENTIAL FLAW: assertion is evaluated */
            assert data.length() > 0;

        }
    }

    /* goodG2B() - use goodsource and badsink by moving BadSource and BadSink to after return */
    private void goodG2B() throws Throwable
    {
        String data;
        {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

            /* POTENTIAL FLAW: assertion is evaluated */
            assert data.length() > 0;

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            Logger log_bad = Logger.getLogger("local-logger");

            /* get environment variable ADD */
            data = System.getenv("ADD");

            /* POTENTIAL FLAW: assertion is evaluated */
            assert data.length() > 0;

        }
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
