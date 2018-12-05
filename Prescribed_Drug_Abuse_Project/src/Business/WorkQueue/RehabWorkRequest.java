/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author hetashavi
 */
public class RehabWorkRequest extends WorkRequest {
    
    private String patientTag;
    private String testResult;
    private String drug;

    public String getPatientTag() {
        return patientTag;
    }

    public void setPatientTag(String patientTag) {
        this.patientTag = patientTag;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }
    
    
    
}
