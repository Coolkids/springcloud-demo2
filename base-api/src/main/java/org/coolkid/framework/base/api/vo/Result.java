package org.coolkid.framework.base.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by coolkid on 2021/11/25.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private String msg;
    private Date ts;
    private String mid;
    private String sessionId;
}
