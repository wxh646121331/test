package com.wxh.alg.km;

import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/16
 * @time: 上午8:22
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
@Getter
public class Vertex {
    @Setter
    private int index;
    private String key;
    private VertexType vertexType;
    private int value;

    public void setValue(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(vertexType).append("_").append(key).append(":").append(value);
        return sb.toString();
    }

    public static class Builder{
        private String key;
        private VertexType vertexType;

        public static Builder newInstance(){
            return new Builder();
        }

        public Builder key(String key) {
            this.key = key;
            return this;
        }

        public Builder vertexType(VertexType vertexType){
            this.vertexType = vertexType;
            return this;
        }

        public Vertex build(){
            Vertex vertex = new Vertex();
            vertex.key = this.key;
            vertex.vertexType = this.vertexType;
            return vertex;
        }
    }
}
