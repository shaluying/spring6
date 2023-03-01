package com.shaluy.proxy.service;

public class OrderServiceImplSub extends OrderServiceImpl {
    @Override
    public void generate() {
        long star = System.currentTimeMillis();

        super.generate();

        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end-star)+"ms");
    }

    @Override
    public void modify() {
        long star = System.currentTimeMillis();

        super.modify();

        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end-star)+"ms");
    }

    @Override
    public void detail() {
        long star = System.currentTimeMillis();

        super.detail();

        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end-star)+"ms");
    }
}
