package com.handpay.laucher.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 下载安装包信息
 */

@Entity
public class AppData {
    @Id
    public Long id;
    public String pageNo;       //第几页
    public String pageTotal;    //总页数
    public int iconResId;       //图标
    public String label;        //名称
    public int bgColor;         //背景色
    public int bgIndex;         //背景色块位置标签
    public String packageName;  //包名
    public String version;      //版本号
    public long size;           //总大小
    public long LoadedSize;     //已下载大小
    public long LoadingSize;    //下载中大小
    public boolean loadStatus;  //下载状态
    public boolean hasUpdate;   //是否有更新

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"version\":\"")
                .append(version).append('\"');
        sb.append(",\"size\":")
                .append(size);
        sb.append(",\"pageTotal\":\"")
                .append(pageTotal).append('\"');
        sb.append(",\"pageNo\":\"")
                .append(pageNo).append('\"');
        sb.append(",\"packageName\":\"")
                .append(packageName).append('\"');
        sb.append(",\"loadStatus\":")
                .append(loadStatus);
        sb.append(",\"loadingSize\":")
                .append(getLoadingSize());
        sb.append(",\"LoadedSize\":")
                .append(LoadedSize);
        sb.append(",\"label\":\"")
                .append(label).append('\"');
        sb.append(",\"id\":")
                .append(id);
        sb.append(",\"iconResId\":")
                .append(iconResId);
        sb.append(",\"hasUpdate\":")
                .append(hasUpdate);
        sb.append(",\"bgIndex\":")
                .append(bgIndex);
        sb.append(",\"bgColor\":")
                .append(bgColor);
        sb.append('}');
        return sb.toString();
    }

    @Generated(hash = 410327285)
    public AppData(Long id, String pageNo, String pageTotal, int iconResId,
                   String label, int bgColor, int bgIndex, String packageName,
                   String version, long size, long LoadedSize, long LoadingSize,
                   boolean loadStatus, boolean hasUpdate) {
        this.id = id;
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.iconResId = iconResId;
        this.label = label;
        this.bgColor = bgColor;
        this.bgIndex = bgIndex;
        this.packageName = packageName;
        this.version = version;
        this.size = size;
        this.LoadedSize = LoadedSize;
        this.LoadingSize = LoadingSize;
        this.loadStatus = loadStatus;
        this.hasUpdate = hasUpdate;
    }

    @Generated(hash = 1112619805)
    public AppData() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageTotal() {
        return this.pageTotal;
    }

    public void setPageTotal(String pageTotal) {
        this.pageTotal = pageTotal;
    }

    public int getIconResId() {
        return this.iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public int getBgIndex() {
        return this.bgIndex;
    }

    public void setBgIndex(int bgIndex) {
        this.bgIndex = bgIndex;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getLoadedSize() {
        return this.LoadedSize;
    }

    public void setLoadedSize(long LoadedSize) {
        this.LoadedSize = LoadedSize;
    }

    public long getLoadingSize() {
        return this.LoadingSize;
    }

    public void setLoadingSize(long LoadingSize) {
        this.LoadingSize = LoadingSize;
    }

    public boolean getLoadStatus() {
        return this.loadStatus;
    }

    public void setLoadStatus(boolean loadStatus) {
        this.loadStatus = loadStatus;
    }

    public boolean getHasUpdate() {
        return this.hasUpdate;
    }

    public void setHasUpdate(boolean hasUpdate) {
        this.hasUpdate = hasUpdate;
    }


}
