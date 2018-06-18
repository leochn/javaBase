package com.vnext.w22designpattern.d12dacade;

import java.util.Queue;

/**
 * 基金
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 18:04:02
 */
public class JiJin {

    private GuoZai guoZai;
    private GuPiao guPiao;
    private QiHuo qiHuo;

    public JiJin() {
        this.guoZai = new GuoZai();
        this.guPiao = new GuPiao();
        this.qiHuo = new QiHuo();
    }

    // 买基金A
    public void maiJiJinA(){
        this.guoZai.mai();
        this.guPiao.chao();
        this.qiHuo.mai();
    }

    // 买基金A
    public void maiJiJinB(){
        this.guoZai.mai();
        this.guPiao.chao();
    }
}