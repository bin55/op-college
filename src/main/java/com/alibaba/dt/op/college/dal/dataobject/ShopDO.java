package com.alibaba.dt.op.college.dal.dataobject;
import java.util.Date;
import com.alibaba.dt.op.lang.model.BaseModel;
/**
 * OpShop 店铺模型
 * 
 * @author songjian.shousj
 */
public class ShopDO extends BaseModel {
    /**
     * 
     */
    private static final long serialVersionUID = 6454787536189589193L;
    /**
     * 用户id
     */
    private Long    userId;
    /**
     * 主店企业名称
     */
    private String  companyName;
    /**
     * 店铺个数（包含当前主店铺）
     */
    private Integer shopCount;
    /**
     * 所属一级类目
     */
    private Integer categoryLevel1Id;
    /**
     * 店铺类型 99=所有 0=淘宝 1=天猫
     */
    private Integer shopType;
    /**
     * 创建时间
     */
    private Date    gmtCreate;
    /**
     * 订购时间
     */
    private Date    gmtOrder;
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public Integer getShopCount() {
        return shopCount;
    }
    public void setShopCount(Integer shopCount) {
        this.shopCount = shopCount;
    }
    public Integer getCategoryLevel1Id() {
        return categoryLevel1Id;
    }
    public void setCategoryLevel1Id(Integer categoryLevel1Id) {
        this.categoryLevel1Id = categoryLevel1Id;
    }
    public Integer getShopType() {
        return shopType;
    }
    public void setShopType(Integer shopType) {
        this.shopType = shopType;
    }
    public Date getGmtCreate() {
        return gmtCreate;
    }
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
    public Date getGmtOrder() {
        return gmtOrder;
    }
    public void setGmtOrder(Date gmtOrder) {
        this.gmtOrder = gmtOrder;
    }
}
