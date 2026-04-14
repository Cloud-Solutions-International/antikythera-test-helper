/*
 * Decompiled with CFR 0.152.
 */
package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

import java.util.List;

public class FakeSearchModel {
    private Long patientId;
    private Long doctorId;
    private Long recordId;
    private Long parentId;
    private Long episodeId;
    private Long itemId;
    private Long clinicId;
    private Boolean isActive;
    private Boolean isResolved;
    private Boolean isPreviousProblem;
    private List<Long> moduleList;
    private List<Long> parentLocationList;
    private List<Long> locationList;
    private Long hospitalId;
    private Long hospitalGroupId;
    private Long createdBy;
    private Long modifiedBy;
    private Long loginUserId;

    public Long getPatientId() {
        return this.patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return this.doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getRecordId() {
        return this.recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getEpisodeId() {
        return this.episodeId;
    }

    public void setEpisodeId(Long episodeId) {
        this.episodeId = episodeId;
    }

    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getClinicId() {
        return this.clinicId;
    }

    public void setClinicId(Long clinicId) {
        this.clinicId = clinicId;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsResolved() {
        return this.isResolved;
    }

    public void setIsResolved(Boolean isResolved) {
        this.isResolved = isResolved;
    }

    public Boolean getIsPreviousProblem() {
        return this.isPreviousProblem;
    }

    public void setIsPreviousProblem(Boolean isPreviousProblem) {
        this.isPreviousProblem = isPreviousProblem;
    }

    public List<Long> getModuleList() {
        return this.moduleList;
    }

    public void setModuleList(List<Long> moduleList) {
        this.moduleList = moduleList;
    }

    public List<Long> getParentLocationList() {
        return this.parentLocationList;
    }

    public void setParentLocationList(List<Long> parentLocationList) {
        this.parentLocationList = parentLocationList;
    }

    public List<Long> getLocationList() {
        return this.locationList;
    }

    public void setLocationList(List<Long> locationList) {
        this.locationList = locationList;
    }

    public Long getHospitalId() {
        return this.hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Long getHospitalGroupId() {
        return this.hospitalGroupId;
    }

    public void setHospitalGroupId(Long hospitalGroupId) {
        this.hospitalGroupId = hospitalGroupId;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getLoginUserId() {
        return this.loginUserId;
    }

    public void setLoginUserId(Long loginUserId) {
        this.loginUserId = loginUserId;
    }
}
