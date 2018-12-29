package cn.temptation.domain;

import java.util.Date;

public class Testcase {
    private String id;

    private String folderid;

    private String code;

    private String name;

    private String description;

    private String priority;

    private Boolean iscontinue;

    private String updateuser;

    private String updateusername;

    private Date createdate;

    private Date updatedate;

    private Short platformtype;

    private String conditionid;

    private String nameformatconfig;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFolderid() {
        return folderid;
    }

    public void setFolderid(String folderid) {
        this.folderid = folderid == null ? null : folderid.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
    }

    public Boolean getIscontinue() {
        return iscontinue;
    }

    public void setIscontinue(Boolean iscontinue) {
        this.iscontinue = iscontinue;
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser == null ? null : updateuser.trim();
    }

    public String getUpdateusername() {
        return updateusername;
    }

    public void setUpdateusername(String updateusername) {
        this.updateusername = updateusername == null ? null : updateusername.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Short getPlatformtype() {
        return platformtype;
    }

    public void setPlatformtype(Short platformtype) {
        this.platformtype = platformtype;
    }

    public String getConditionid() {
        return conditionid;
    }

    public void setConditionid(String conditionid) {
        this.conditionid = conditionid == null ? null : conditionid.trim();
    }

    public String getNameformatconfig() {
        return nameformatconfig;
    }

    public void setNameformatconfig(String nameformatconfig) {
        this.nameformatconfig = nameformatconfig == null ? null : nameformatconfig.trim();
    }
}