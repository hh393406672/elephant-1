package com.sjhy.platform.client.dto.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ip记录表
 * 
 * @author HJ
 * 
 * @date 2018-12-06
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IpLocation {
    /**
     * 开始ip数
     */
    private Long startIpNum;

    /**
     * 结束ip数
     */
    private Long endIpNum;

    /**
     * 标识
     */
    private Integer locid;

}