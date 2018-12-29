package cn.temptation.domain;

import java.util.Date;

public class Channel {
    private Integer id;

    private String name;

    private String channelid;

    private String manager;

    private String projectleader;

    private String hexinnemdianid;

    private Integer productqixian;

    private String description;

    private String ipaddress;

    private Short portnumber;

    private String serviceip;

    private String baowenlujing;

    private Boolean isenable;

    private Date lasttimestamp;

    private String cooperationtype;

    private Short status;

    private Boolean isdelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid == null ? null : channelid.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getProjectleader() {
        return projectleader;
    }

    public void setProjectleader(String projectleader) {
        this.projectleader = projectleader == null ? null : projectleader.trim();
    }

    public String getHexinnemdianid() {
        return hexinnemdianid;
    }

    public void setHexinnemdianid(String hexinnemdianid) {
        this.hexinnemdianid = hexinnemdianid == null ? null : hexinnemdianid.trim();
    }

    public Integer getProductqixian() {
        return productqixian;
    }

    public void setProductqixian(Integer productqixian) {
        this.productqixian = productqixian;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress == null ? null : ipaddress.trim();
    }

    public Short getPortnumber() {
        return portnumber;
    }

    public void setPortnumber(Short portnumber) {
        this.portnumber = portnumber;
    }

    public String getServiceip() {
        return serviceip;
    }

    public void setServiceip(String serviceip) {
        this.serviceip = serviceip == null ? null : serviceip.trim();
    }

    public String getBaowenlujing() {
        return baowenlujing;
    }

    public void setBaowenlujing(String baowenlujing) {
        this.baowenlujing = baowenlujing == null ? null : baowenlujing.trim();
    }

    public Boolean getIsenable() {
        return isenable;
    }

    public void setIsenable(Boolean isenable) {
        this.isenable = isenable;
    }

    public Date getLasttimestamp() {
        return lasttimestamp;
    }

    public void setLasttimestamp(Date lasttimestamp) {
        this.lasttimestamp = lasttimestamp;
    }

    public String getCooperationtype() {
        return cooperationtype;
    }

    public void setCooperationtype(String cooperationtype) {
        this.cooperationtype = cooperationtype == null ? null : cooperationtype.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}