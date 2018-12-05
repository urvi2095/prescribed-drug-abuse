/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author urvi
 */
public class LabTestWorkRequest extends WorkRequest{
    
    private String testResult;
    private String testPatient;

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getTestPatient() {
        return testPatient;
    }

    public void setTestPatient(String testPatient) {
        this.testPatient = testPatient;
    }
    
    
    
    
}
