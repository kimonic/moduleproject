package com.kimonic.notebook.litemapbean.invest;

import org.litepal.crud.DataSupport;

/**
 * * ===============================================================
 * name:             DataNameTableLMBean
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/2
 * description：  投资记录详情表
 * history：
 * *==================================================================
 */

public class InvestmentRecordDetailsLMBean extends DataSupport {

    /**
     * 用户名
     */
    private String userName;
    ////投资平台,投资日期,,回款日期,投资金额,,备注
    /// 回款金额,投资账号,统计标识,是否已到期
    // 固定年化收益
    // 返现金额及其他,额外年化收益,总年化收益,总收益,投资天数,
    // 投资手机号
    //修改次数,最后修改日期 ,投资年份,投资月份,唯一标识
    /**
     * 投资年份
     */
    private String year;
    /**
     * 投资月份
     */
    private String month;
    /**
     * 投资平台
     */
    private String investPlateform;
    /**
     * 投资日期
     */
    private String investDate;
    /**
     * 回款日期
     */
    private String repayDate;
    /**
     * 投资金额
     */
    private float investAmount;
    /**
     * 回款金额
     */
    private float repayAmount;
    /**
     * 投资账号
     */
    private String investAcounts;
    /**
     * 备注
     */
    private String mark;
    /**
     * 统计标识,月度年度统计只包含为TRUE的记录
     */
    private boolean validFlag = true;
    /**
     * 是否已到期
     */
    private boolean matureFlag = false;
    /**
     * 唯一标识
     */
    private long id;
    /**
     * 固定年化收益
     */
    private String fixedAnnualIncom;
    /**
     * 返现金额及其他
     */
    private float cashBack;
    /**
     * 额外年化收益
     */
    private String extraAnnualIncome;
    /**
     * 总年化收益
     */
    private String totalAnnualIncome;
    /**
     * 总收益
     */
    private float totalIncome;
    /**
     * 投资天数
     */
    private int investNumberOfDays;
    /**
     * 修改次数
     */
    private int modifyNumber = 0;
    /**
     * 最后修改日期
     */
    private String lastModifyDate;
    /**
     * 投资关联手机号
     */
    private String phoneNumer;

    /**
     * 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 投资平台
     */
    public String getInvestPlateform() {
        return investPlateform;
    }

    /**
     * 投资平台
     */
    public void setInvestPlateform(String investPlateform) {
        this.investPlateform = investPlateform;
    }

    /**
     * 投资日期
     */
    public String getInvestDate() {
        return investDate;
    }

    /**
     * 投资日期
     */
    public void setInvestDate(String investDate) {
        this.investDate = investDate;
    }

    /**
     * 回款日期
     */
    public String getRepayDate() {
        return repayDate;
    }

    /**
     * 回款日期
     */
    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    /**
     * 投资金额
     */
    public float getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(float investAmount) {
        this.investAmount = investAmount;
    }

    /**
     * 回款金额
     */
    public float getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(float repayAmount) {
        this.repayAmount = repayAmount;
    }

    /**
     * 投资账号
     */
    public String getInvestAcounts() {
        return investAcounts;
    }

    /**
     * 投资账号
     */
    public void setInvestAcounts(String investAcounts) {
        this.investAcounts = investAcounts;
    }

    /**
     * 备注
     */
    public String getMark() {
        return mark;
    }

    /**
     * 备注
     */
    public void setMark(String mark) {
        this.mark = mark;
    }

    /**
     * 统计标识,月度年度统计只包含为TRUE的记录
     */
    public boolean isValidFlag() {
        return validFlag;
    }

    /**
     * 统计标识,月度年度统计只包含为TRUE的记录
     */
    public void setValidFlag(boolean validFlag) {
        this.validFlag = validFlag;
    }

    /**
     * 是否已到期
     */
    public boolean isMatureFlag() {
        return matureFlag;
    }

    /**
     * 是否已到期
     */
    public void setMatureFlag(boolean matureFlag) {
        this.matureFlag = matureFlag;
    }

    /**
     * 唯一标识
     */
    public long getId() {
        return getBaseObjId();
    }

    /**
     * 固定年化收益
     */

    public String getFixedAnnualIncom() {
        return fixedAnnualIncom;
    }

    /**
     * 固定年化收益
     */
    public void setFixedAnnualIncom(String fixedAnnualIncom) {
        this.fixedAnnualIncom = fixedAnnualIncom;
    }

    /**
     * 返现金额及其他
     */
    public float getCashBack() {
        return cashBack;
    }

    /**
     * 返现金额及其他
     */
    public void setCashBack(float cashBack) {
        this.cashBack = cashBack;
    }

    /**
     * 额外年化收益
     */
    public String getExtraAnnualIncome() {
        return extraAnnualIncome;
    }

    /**
     * 额外年化收益
     */
    public void setExtraAnnualIncome(String extraAnnualIncome) {
        this.extraAnnualIncome = extraAnnualIncome;
    }

    /**
     * 总年化收益
     */
    public String getTotalAnnualIncome() {
        return totalAnnualIncome;
    }

    /**
     * 总年化收益
     */
    public void setTotalAnnualIncome(String totalAnnualIncome) {
        this.totalAnnualIncome = totalAnnualIncome;
    }

    /**
     * 总收益
     */
    public float getTotalIncome() {
        return totalIncome;
    }

    /**
     * 总收益
     */
    public void setTotalIncome(float totalIncome) {
        this.totalIncome = totalIncome;
    }

    /**
     * 投资天数
     */
    public int getInvestNumberOfDays() {
        return investNumberOfDays;
    }

    /**
     * 投资天数
     */
    public void setInvestNumberOfDays(int investNumberOfDays) {
        this.investNumberOfDays = investNumberOfDays;
    }

    /**
     * 修改次数
     */
    public int getModifyNumber() {
        return modifyNumber;
    }

    /**
     * 修改次数
     */
    public void setModifyNumber(int modifyNumber) {
        this.modifyNumber = modifyNumber;
    }

    /**
     * 最后修改日期
     */
    public String getLastModifyDate() {
        return lastModifyDate;
    }

    /**
     * 最后修改日期
     */
    public void setLastModifyDate(String lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    /**
     * 投资关联手机号
     */
    public String getPhoneNumer() {
        return phoneNumer;
    }

    /**
     * 投资关联手机号
     */
    public void setPhoneNumer(String phoneNumer) {
        this.phoneNumer = phoneNumer;
    }

    /**
     * 投资年份
     */
    public String getYear() {
        return year;
    }

    /**
     * 投资年份
     */

    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 投资月份
     */
    public String getMonth() {
        return month;
    }

    /**
     * 投资月份
     */

    public void setMonth(String month) {
        this.month = month;
    }
}
