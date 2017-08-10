package com.wenke.vitamiodemo.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wenke on 2017/7/25.
 */

public class Advertising implements Serializable {


    /**
     * status : ok
     * description : null
     * userinfo : null
     * classinfolist : null
     * childinfolist : null
     * kindergartenlist : {}
     * orgId : 0
     * ImageUrl :
     * mobilepermission : []
     * GuardianFunctionList : []
     * adList : [{"adcontentList":[{"AdContentId":14,"AdId":20,"BroadcastOrder":1,"MediaType":1,"MediaFile":"/Images/WebsiteTemplate/3.jpg","VideoImageFile":null,"Duration":"00:00:06"},{"AdContentId":4,"AdId":20,"BroadcastOrder":3,"MediaType":1,"MediaFile":"/Images/WebsiteTemplate/2.jpg","VideoImageFile":null,"Duration":"00:00:10"},{"AdContentId":17,"AdId":20,"BroadcastOrder":6,"MediaType":2,"MediaFile":"/Upload/20-2.flv","VideoImageFile":null,"Duration":"00:10:03"}],"AdId":20,"Name":"testa","State":1,"AuditState":2,"BeginDate":"2017-07-24 00:00:00","EndDate":"2017-07-26 00:00:00","SourceType":2,"BroadcastType":1,"Keywords":"2","IndustryCategory":1,"BroadcastHours":"1,1","Price":200,"Owner":"化工","OwnerPhone":"123456","OwnerAddress":"","CreatorId":2,"CreateTime":"2017-07-24 10:21:04","Auditor":2,"AuditTime":"2017-07-24 10:21:04"},{"adcontentList":[{"AdContentId":6,"AdId":21,"BroadcastOrder":1,"MediaType":2,"MediaFile":"/Upload/jianbing.mp4","VideoImageFile":null,"Duration":"00:11:18"},{"AdContentId":7,"AdId":21,"BroadcastOrder":2,"MediaType":1,"MediaFile":"/Images/WebsiteTemplate/1.jpg","VideoImageFile":null,"Duration":"00:00:05"}],"AdId":21,"Name":"aaa","State":1,"AuditState":2,"BeginDate":"2017-07-24 00:00:00","EndDate":"2017-07-27 00:00:00","SourceType":3,"BroadcastType":1,"Keywords":"4","IndustryCategory":1,"BroadcastHours":"3,10","Price":200,"Owner":"中石","OwnerPhone":"123456a","OwnerAddress":"","CreatorId":239,"CreateTime":"2017-07-24 11:20:23","Auditor":239,"AuditTime":"2017-07-24 11:20:23"}]
     * Result : {}
     * CameraList : {}
     */

    private String status;
    private Object description;
    private Object userinfo;
    private Object classinfolist;
    private Object childinfolist;
    private KindergartenlistBean kindergartenlist;
    private int orgId;
    private String ImageUrl;
    private ResultBean Result;
    private CameraListBean CameraList;
    private List<?> mobilepermission;
    private List<?> GuardianFunctionList;
    private List<AdListBean> adList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Object userinfo) {
        this.userinfo = userinfo;
    }

    public Object getClassinfolist() {
        return classinfolist;
    }

    public void setClassinfolist(Object classinfolist) {
        this.classinfolist = classinfolist;
    }

    public Object getChildinfolist() {
        return childinfolist;
    }

    public void setChildinfolist(Object childinfolist) {
        this.childinfolist = childinfolist;
    }

    public KindergartenlistBean getKindergartenlist() {
        return kindergartenlist;
    }

    public void setKindergartenlist(KindergartenlistBean kindergartenlist) {
        this.kindergartenlist = kindergartenlist;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String ImageUrl) {
        this.ImageUrl = ImageUrl;
    }

    public ResultBean getResult() {
        return Result;
    }

    public void setResult(ResultBean Result) {
        this.Result = Result;
    }

    public CameraListBean getCameraList() {
        return CameraList;
    }

    public void setCameraList(CameraListBean CameraList) {
        this.CameraList = CameraList;
    }

    public List<?> getMobilepermission() {
        return mobilepermission;
    }

    public void setMobilepermission(List<?> mobilepermission) {
        this.mobilepermission = mobilepermission;
    }

    public List<?> getGuardianFunctionList() {
        return GuardianFunctionList;
    }

    public void setGuardianFunctionList(List<?> GuardianFunctionList) {
        this.GuardianFunctionList = GuardianFunctionList;
    }

    public List<AdListBean> getAdList() {
        return adList;
    }

    public void setAdList(List<AdListBean> adList) {
        this.adList = adList;
    }

    public static class KindergartenlistBean {
    }

    public static class ResultBean {
    }

    public static class CameraListBean {
    }

    public static class AdListBean implements Serializable {
        /**
         * adcontentList : [{"AdContentId":14,"AdId":20,"BroadcastOrder":1,"MediaType":1,"MediaFile":"/Images/WebsiteTemplate/3.jpg","VideoImageFile":null,"Duration":"00:00:06"},{"AdContentId":4,"AdId":20,"BroadcastOrder":3,"MediaType":1,"MediaFile":"/Images/WebsiteTemplate/2.jpg","VideoImageFile":null,"Duration":"00:00:10"},{"AdContentId":17,"AdId":20,"BroadcastOrder":6,"MediaType":2,"MediaFile":"/Upload/20-2.flv","VideoImageFile":null,"Duration":"00:10:03"}]
         * AdId : 20
         * Name : testa
         * State : 1
         * AuditState : 2
         * BeginDate : 2017-07-24 00:00:00
         * EndDate : 2017-07-26 00:00:00
         * SourceType : 2
         * BroadcastType : 1
         * Keywords : 2
         * IndustryCategory : 1
         * BroadcastHours : 1,1
         * Price : 200
         * Owner : 化工
         * OwnerPhone : 123456
         * OwnerAddress :
         * CreatorId : 2
         * CreateTime : 2017-07-24 10:21:04
         * Auditor : 2
         * AuditTime : 2017-07-24 10:21:04
         */

        private int AdId;
        private String Name;
        private int State;
        private int AuditState;
        private String BeginDate;
        private String EndDate;
        private int SourceType;
        private int BroadcastType;
        private String Keywords;
        private int IndustryCategory;
        private String BroadcastHours;
        private int Price;
        private String Owner;
        private String OwnerPhone;
        private String OwnerAddress;
        private int CreatorId;
        private String CreateTime;
        private int Auditor;
        private String AuditTime;
        private List<AdcontentListBean> adcontentList;

        public int getAdId() {
            return AdId;
        }

        public void setAdId(int AdId) {
            this.AdId = AdId;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getState() {
            return State;
        }

        public void setState(int State) {
            this.State = State;
        }

        public int getAuditState() {
            return AuditState;
        }

        public void setAuditState(int AuditState) {
            this.AuditState = AuditState;
        }

        public String getBeginDate() {
            return BeginDate;
        }

        public void setBeginDate(String BeginDate) {
            this.BeginDate = BeginDate;
        }

        public String getEndDate() {
            return EndDate;
        }

        public void setEndDate(String EndDate) {
            this.EndDate = EndDate;
        }

        public int getSourceType() {
            return SourceType;
        }

        public void setSourceType(int SourceType) {
            this.SourceType = SourceType;
        }

        public int getBroadcastType() {
            return BroadcastType;
        }

        public void setBroadcastType(int BroadcastType) {
            this.BroadcastType = BroadcastType;
        }

        public String getKeywords() {
            return Keywords;
        }

        public void setKeywords(String Keywords) {
            this.Keywords = Keywords;
        }

        public int getIndustryCategory() {
            return IndustryCategory;
        }

        public void setIndustryCategory(int IndustryCategory) {
            this.IndustryCategory = IndustryCategory;
        }

        public String getBroadcastHours() {
            return BroadcastHours;
        }

        public void setBroadcastHours(String BroadcastHours) {
            this.BroadcastHours = BroadcastHours;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
            this.Price = Price;
        }

        public String getOwner() {
            return Owner;
        }

        public void setOwner(String Owner) {
            this.Owner = Owner;
        }

        public String getOwnerPhone() {
            return OwnerPhone;
        }

        public void setOwnerPhone(String OwnerPhone) {
            this.OwnerPhone = OwnerPhone;
        }

        public String getOwnerAddress() {
            return OwnerAddress;
        }

        public void setOwnerAddress(String OwnerAddress) {
            this.OwnerAddress = OwnerAddress;
        }

        public int getCreatorId() {
            return CreatorId;
        }

        public void setCreatorId(int CreatorId) {
            this.CreatorId = CreatorId;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getAuditor() {
            return Auditor;
        }

        public void setAuditor(int Auditor) {
            this.Auditor = Auditor;
        }

        public String getAuditTime() {
            return AuditTime;
        }

        public void setAuditTime(String AuditTime) {
            this.AuditTime = AuditTime;
        }

        public List<AdcontentListBean> getAdcontentList() {
            return adcontentList;
        }

        public void setAdcontentList(List<AdcontentListBean> adcontentList) {
            this.adcontentList = adcontentList;
        }

        public static class AdcontentListBean {
            /**
             * AdContentId : 14
             * AdId : 20
             * BroadcastOrder : 1
             * MediaType : 1
             * MediaFile : /Images/WebsiteTemplate/3.jpg
             * VideoImageFile : null
             * Duration : 00:00:06
             */

            private int AdContentId;
            private int AdId;
            private int BroadcastOrder;
            private int MediaType;
            private String MediaFile;
            private Object VideoImageFile;
            private String Duration;

            public int getAdContentId() {
                return AdContentId;
            }

            public void setAdContentId(int AdContentId) {
                this.AdContentId = AdContentId;
            }

            public int getAdId() {
                return AdId;
            }

            public void setAdId(int AdId) {
                this.AdId = AdId;
            }

            public int getBroadcastOrder() {
                return BroadcastOrder;
            }

            public void setBroadcastOrder(int BroadcastOrder) {
                this.BroadcastOrder = BroadcastOrder;
            }

            public int getMediaType() {
                return MediaType;
            }

            public void setMediaType(int MediaType) {
                this.MediaType = MediaType;
            }

            public String getMediaFile() {
                return MediaFile;
            }

            public void setMediaFile(String MediaFile) {
                this.MediaFile = MediaFile;
            }

            public Object getVideoImageFile() {
                return VideoImageFile;
            }

            public void setVideoImageFile(Object VideoImageFile) {
                this.VideoImageFile = VideoImageFile;
            }

            public String getDuration() {
                return Duration;
            }

            public void setDuration(String Duration) {
                this.Duration = Duration;
            }

            @Override
            public String toString() {
                return "AdcontentListBean{" +
                        "AdContentId=" + AdContentId +
                        ", AdId=" + AdId +
                        ", BroadcastOrder=" + BroadcastOrder +
                        ", MediaType=" + MediaType +
                        ", MediaFile='" + MediaFile + '\'' +
                        ", VideoImageFile=" + VideoImageFile +
                        ", Duration='" + Duration + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "AdListBean{" +
                    "AdId=" + AdId +
                    ", Name='" + Name + '\'' +
                    ", State=" + State +
                    ", AuditState=" + AuditState +
                    ", BeginDate='" + BeginDate + '\'' +
                    ", EndDate='" + EndDate + '\'' +
                    ", SourceType=" + SourceType +
                    ", BroadcastType=" + BroadcastType +
                    ", Keywords='" + Keywords + '\'' +
                    ", IndustryCategory=" + IndustryCategory +
                    ", BroadcastHours='" + BroadcastHours + '\'' +
                    ", Price=" + Price +
                    ", Owner='" + Owner + '\'' +
                    ", OwnerPhone='" + OwnerPhone + '\'' +
                    ", OwnerAddress='" + OwnerAddress + '\'' +
                    ", CreatorId=" + CreatorId +
                    ", CreateTime='" + CreateTime + '\'' +
                    ", Auditor=" + Auditor +
                    ", AuditTime='" + AuditTime + '\'' +
                    ", adcontentList=" + adcontentList +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Advertising{" +
                "status='" + status + '\'' +
                ", description=" + description +
                ", userinfo=" + userinfo +
                ", classinfolist=" + classinfolist +
                ", childinfolist=" + childinfolist +
                ", kindergartenlist=" + kindergartenlist +
                ", orgId=" + orgId +
                ", ImageUrl='" + ImageUrl + '\'' +
                ", Result=" + Result +
                ", CameraList=" + CameraList +
                ", mobilepermission=" + mobilepermission +
                ", GuardianFunctionList=" + GuardianFunctionList +
                ", adList=" + adList +
                '}';
    }
}
