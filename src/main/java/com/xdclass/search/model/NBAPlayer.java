package com.xdclass.search.model;

public class NBAPlayer {
    private Integer id;
    private String countryEn;
    private String country;
    private String code;
    private String displayAffiliation;
    private String displayName;
    private Integer draft;
    private String schoolType;
    private String weight;
    private Integer playYear;
    private String jerseyNo;
    private Long birthDay;
    private String birthDayStr;
    private String displayNameEn;
    private String position;
    private Double heightValue;
    private String playerId;
    private String teamCity;
    private String teamCityEn;
    private String teamName;
    private String teamNameEn;
    private String teamConference;
    private String teamConferenceEn;
    private Integer age;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBirthDayStr() {
        return birthDayStr;
    }

    public void setBirthDayStr(String birthDayStr) {
        this.birthDayStr = birthDayStr;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDisplayAffiliation() {
        return displayAffiliation;
    }

    public void setDisplayAffiliation(String displayAffiliation) {
        this.displayAffiliation = displayAffiliation;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getDraft() {
        return draft;
    }

    public void setDraft(Integer draft) {
        this.draft = draft;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Integer getPlayYear() {
        return playYear;
    }

    public void setPlayYear(Integer playYear) {
        this.playYear = playYear;
    }

    public String getCountryEn() {
        return countryEn;
    }

    public void setCountryEn(String countryEn) {
        this.countryEn = countryEn;
    }

    public String getTeamCityEn() {
        return teamCityEn;
    }

    public void setTeamCityEn(String teamCityEn) {
        this.teamCityEn = teamCityEn;
    }

    public String getTeamNameEn() {
        return teamNameEn;
    }

    public void setTeamNameEn(String teamNameEn) {
        this.teamNameEn = teamNameEn;
    }

    public String getTeamConference() {
        return teamConference;
    }

    public void setTeamConference(String teamConference) {
        this.teamConference = teamConference;
    }

    public String getTeamConferenceEn() {
        return teamConferenceEn;
    }

    public void setTeamConferenceEn(String teamConferenceEn) {
        this.teamConferenceEn = teamConferenceEn;
    }

    public String getJerseyNo() {
        return jerseyNo;
    }

    public void setJerseyNo(String jerseyNo) {
        this.jerseyNo = jerseyNo;
    }

    public Long getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Long birthDay) {
        this.birthDay = birthDay;
    }

    public String getDisplayNameEn() {
        return displayNameEn;
    }

    public void setDisplayNameEn(String displayNameEn) {
        this.displayNameEn = displayNameEn;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public Double getHeightValue() {
        return heightValue;
    }

    public void setHeightValue(Double heightValue) {
        this.heightValue = heightValue;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getTeamCity() {
        return teamCity;
    }

    public void setTeamCity(String teamCity) {
        this.teamCity = teamCity;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NBAPlayer{");
        sb.append("id=").append(id);
        sb.append(", countryEn='").append(countryEn).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", code='").append(code).append('\'');
        sb.append(", displayAffiliation='").append(displayAffiliation).append('\'');
        sb.append(", displayName='").append(displayName).append('\'');
        sb.append(", draft=").append(draft);
        sb.append(", schoolType='").append(schoolType).append('\'');
        sb.append(", weight='").append(weight).append('\'');
        sb.append(", playYear=").append(playYear);
        sb.append(", jerseyNo='").append(jerseyNo).append('\'');
        sb.append(", birthDay=").append(birthDay);
        sb.append(", birthDayStr='").append(birthDayStr).append('\'');
        sb.append(", displayNameEn='").append(displayNameEn).append('\'');
        sb.append(", position='").append(position).append('\'');
        sb.append(", heightValue=").append(heightValue);
        sb.append(", playerId='").append(playerId).append('\'');
        sb.append(", teamCity='").append(teamCity).append('\'');
        sb.append(", teamCityEn='").append(teamCityEn).append('\'');
        sb.append(", teamName='").append(teamName).append('\'');
        sb.append(", teamNameEn='").append(teamNameEn).append('\'');
        sb.append(", teamConference='").append(teamConference).append('\'');
        sb.append(", teamConferenceEn='").append(teamConferenceEn).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
