package com.yzx.wiki.service;

import com.yzx.wiki.domain.Ebook;
import com.yzx.wiki.domain.EbookExample;
import com.yzx.wiki.mapper.EbookMapper;
import com.yzx.wiki.req.EbookReq;
import com.yzx.wiki.resp.EbookResp;
import com.yzx.wiki.util.CopyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {

    @Autowired
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq ebookReq){
        //如果是书名,书名like
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%"+ebookReq.getName()+"%");
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        return CopyUtil.copyList(ebookList, EbookResp.class);
    }
}
