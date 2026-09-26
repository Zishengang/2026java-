package com.chapter05;

import org.apache.ibatis.annotations.Param;
public interface Dept2Mapper {
    Dept2 findDeptById(@Param("did") Integer did);
}