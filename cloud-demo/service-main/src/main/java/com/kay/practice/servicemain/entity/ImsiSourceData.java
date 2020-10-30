package com.kay.practice.servicemain.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.crab2died.annotation.ExcelField;
import com.kay.practice.servicemain.common.DateTimeConverter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * IMSI源数据
 *
 * @author mayue
 * @date 2020-10-26
 */
@Data
@ToString
@ApiModel(value = "IMSI源数据")
public class ImsiSourceData {
    /**
     * 源数据表主键
     */
    @ApiModelProperty("源数据表主键")
    private Integer id;
    /**
     * 数据ID
     */
    @ApiModelProperty("数据ID")
    private Integer entryId;
    /**
     * 时间
     */
    @ApiModelProperty("时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String datetime;
    /**
     * 设备编号
     */
    @ApiModelProperty("设备编号")
    @ExcelField(title = "设备编号", order = 2)
    private String deviceid;
    /**
     * imei
     */
    @ApiModelProperty("imei")
    private String imei;
    /**
     * imsi
     */
    @ApiModelProperty("imsi")
    @ExcelField(title = "IMSI", order = 1)
    private String imsi;
    /**
     * 运营商
     */
    @ApiModelProperty("运营商")
    private String opc;
    /**
     * 上报时间
     */
    @ApiModelProperty("上报时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ExcelField(title = "采集时间", order = 3, writeConverter = DateTimeConverter.class)
    private Long reportTime;
    /**
     * uid
     */
    @ApiModelProperty("uid")
    private String uid;
    /**
     * 归属地
     */
    @ApiModelProperty("归属地")
    @ExcelField(title = "归属地", order = 4)
    private String homeLocation;
    /**
     * 运营商
     */
    @ApiModelProperty("运营商")
    @ExcelField(title = "运营商", order = 5)
    private String networkOperator;
    /**
     * 网络制式
     */
    @ApiModelProperty("网络制式")
    @ExcelField(title = "网络制式", order = 6)
    private String terminalNetworkInformation;
}
