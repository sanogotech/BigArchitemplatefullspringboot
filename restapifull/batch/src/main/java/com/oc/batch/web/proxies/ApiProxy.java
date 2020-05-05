package com.oc.batch.web.proxies;

import java.util.List;

import com.oc.batch.model.beans.BorrowBean;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ApiProxi
 */
@FeignClient(name = "${api.name}", url = "${api.url}")
public interface ApiProxy {

    @GetMapping(value="/borrows")
    public List<BorrowBean> getBorrows();
}