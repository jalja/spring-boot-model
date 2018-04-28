package com.jalja.org.boot.model.vo;

import com.jalja.org.boot.model.TbArticle;
import com.jalja.org.boot.model.TbAuthor;
import com.jalja.org.boot.model.TbTutorial;

import java.io.Serializable;


public class ArticleVO extends TbArticle implements Serializable {
    private TbAuthor tbAuthor;
    private TbTutorial tbTutorial;

    public TbTutorial getTbTutorial() {
        return tbTutorial;
    }

    public void setTbTutorial(TbTutorial tbTutorial) {
        this.tbTutorial = tbTutorial;
    }

    public TbAuthor getTbAuthor() {
        return tbAuthor;
    }

    public void setTbAuthor(TbAuthor tbAuthor) {
        this.tbAuthor = tbAuthor;
    }
}
