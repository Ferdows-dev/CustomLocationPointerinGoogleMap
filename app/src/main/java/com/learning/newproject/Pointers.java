package com.learning.newproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pointers {


        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("latitude")
        @Expose
        private Double latitude;
        @SerializedName("longitude")
        @Expose
        private Double longitude;
        @SerializedName("altitude")
        @Expose
        private String altitude;
        @SerializedName("town")
        @Expose
        private String town;
        @SerializedName("zipCode")
        @Expose
        private String zipCode;
        @SerializedName("province")
        @Expose
        private String province;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("detailsdescription")
        @Expose
        private String detailsdescription;
        @SerializedName("tags")
        @Expose
        private String tags;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("panoPortal")
        @Expose
        private String panoPortal;
        @SerializedName("Portal360")
        @Expose
        private String portal360;
        @SerializedName("Portal3d")
        @Expose
        private String portal3d;
        @SerializedName("spherical")
        @Expose
        private Object spherical;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("userRated")
        @Expose
        private Integer userRated;
        @SerializedName("rates")
        @Expose
        private Integer rates;
        @SerializedName("isBuilding")
        @Expose
        private Integer isBuilding;
        @SerializedName("is_building_3d")
        @Expose
        private Integer isBuilding3d;
        @SerializedName("activity_id")
        @Expose
        private Integer activityId;
        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("deliverable")
        @Expose
        private Integer deliverable;
        @SerializedName("website")
        @Expose
        private Object website;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private Object updatedAt;
        @SerializedName("package")
        @Expose
        private String _package;
        @SerializedName("start")
        @Expose
        private String start;
        @SerializedName("expired")
        @Expose
        private String expired;
        @SerializedName("image_directory")
        @Expose
        private Object imageDirectory;
        @SerializedName("panoPortal_directory")
        @Expose
        private Object panoPortalDirectory;
        @SerializedName("Portal360_directory")
        @Expose
        private Object portal360Directory;
        @SerializedName("spherical_directory")
        @Expose
        private Object sphericalDirectory;
        @SerializedName("Portal3d_directory")
        @Expose
        private Object portal3dDirectory;
        @SerializedName("activity")
        @Expose
        private Object activity;
        @SerializedName("user")
        @Expose
        private User user;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public String getAltitude() {
            return altitude;
        }

        public void setAltitude(String altitude) {
            this.altitude = altitude;
        }

        public String getTown() {
            return town;
        }

        public void setTown(String town) {
            this.town = town;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getDetailsdescription() {
            return detailsdescription;
        }

        public void setDetailsdescription(String detailsdescription) {
            this.detailsdescription = detailsdescription;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getPanoPortal() {
            return panoPortal;
        }

        public void setPanoPortal(String panoPortal) {
            this.panoPortal = panoPortal;
        }

        public String getPortal360() {
            return portal360;
        }

        public void setPortal360(String portal360) {
            this.portal360 = portal360;
        }

        public String getPortal3d() {
            return portal3d;
        }

        public void setPortal3d(String portal3d) {
            this.portal3d = portal3d;
        }

        public Object getSpherical() {
            return spherical;
        }

        public void setSpherical(Object spherical) {
            this.spherical = spherical;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getUserRated() {
            return userRated;
        }

        public void setUserRated(Integer userRated) {
            this.userRated = userRated;
        }

        public Integer getRates() {
            return rates;
        }

        public void setRates(Integer rates) {
            this.rates = rates;
        }

        public Integer getIsBuilding() {
            return isBuilding;
        }

        public void setIsBuilding(Integer isBuilding) {
            this.isBuilding = isBuilding;
        }

        public Integer getIsBuilding3d() {
            return isBuilding3d;
        }

        public void setIsBuilding3d(Integer isBuilding3d) {
            this.isBuilding3d = isBuilding3d;
        }

        public Integer getActivityId() {
            return activityId;
        }

        public void setActivityId(Integer activityId) {
            this.activityId = activityId;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getDeliverable() {
            return deliverable;
        }

        public void setDeliverable(Integer deliverable) {
            this.deliverable = deliverable;
        }

        public Object getWebsite() {
            return website;
        }

        public void setWebsite(Object website) {
            this.website = website;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public Object getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Object updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getPackage() {
            return _package;
        }

        public void setPackage(String _package) {
            this._package = _package;
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getExpired() {
            return expired;
        }

        public void setExpired(String expired) {
            this.expired = expired;
        }

        public Object getImageDirectory() {
            return imageDirectory;
        }

        public void setImageDirectory(Object imageDirectory) {
            this.imageDirectory = imageDirectory;
        }

        public Object getPanoPortalDirectory() {
            return panoPortalDirectory;
        }

        public void setPanoPortalDirectory(Object panoPortalDirectory) {
            this.panoPortalDirectory = panoPortalDirectory;
        }

        public Object getPortal360Directory() {
            return portal360Directory;
        }

        public void setPortal360Directory(Object portal360Directory) {
            this.portal360Directory = portal360Directory;
        }

        public Object getSphericalDirectory() {
            return sphericalDirectory;
        }

        public void setSphericalDirectory(Object sphericalDirectory) {
            this.sphericalDirectory = sphericalDirectory;
        }

        public Object getPortal3dDirectory() {
            return portal3dDirectory;
        }

        public void setPortal3dDirectory(Object portal3dDirectory) {
            this.portal3dDirectory = portal3dDirectory;
        }

        public Object getActivity() {
            return activity;
        }

        public void setActivity(Object activity) {
            this.activity = activity;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

    }

    class User {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("avatar")
        @Expose
        private String avatar;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("role")
        @Expose
        private Integer role;
        @SerializedName("banned")
        @Expose
        private Integer banned;
        @SerializedName("activity_id")
        @Expose
        private Integer activityId;
        @SerializedName("company")
        @Expose
        private String company;
        @SerializedName("country_id")
        @Expose
        private Integer countryId;
        @SerializedName("phoneNumber")
        @Expose
        private Object phoneNumber;
        @SerializedName("age")
        @Expose
        private Object age;
        @SerializedName("email_verified_at")
        @Expose
        private Object emailVerifiedAt;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("avatar_directory")
        @Expose
        private String avatarDirectory;

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
            this.name = name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Integer getRole() {
            return role;
        }

        public void setRole(Integer role) {
            this.role = role;
        }

        public Integer getBanned() {
            return banned;
        }

        public void setBanned(Integer banned) {
            this.banned = banned;
        }

        public Integer getActivityId() {
            return activityId;
        }

        public void setActivityId(Integer activityId) {
            this.activityId = activityId;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public Integer getCountryId() {
            return countryId;
        }

        public void setCountryId(Integer countryId) {
            this.countryId = countryId;
        }

        public Object getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(Object phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public Object getEmailVerifiedAt() {
            return emailVerifiedAt;
        }

        public void setEmailVerifiedAt(Object emailVerifiedAt) {
            this.emailVerifiedAt = emailVerifiedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getAvatarDirectory() {
            return avatarDirectory;
        }

        public void setAvatarDirectory(String avatarDirectory) {
            this.avatarDirectory = avatarDirectory;
        }

    }



