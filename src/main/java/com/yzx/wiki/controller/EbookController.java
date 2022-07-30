package com.yzx.wiki.controller;

import com.yzx.wiki.req.EbookReq;
import com.yzx.wiki.resp.CommonResp;
import com.yzx.wiki.resp.EbookResp;
import com.yzx.wiki.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Autowired
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp list(EbookReq ebookReq){
        CommonResp<List<EbookResp>> resp = new CommonResp<>();
        List<EbookResp> ebookList = ebookService.list(ebookReq);
        resp.setContent(ebookList);
        return resp;
    }
}
