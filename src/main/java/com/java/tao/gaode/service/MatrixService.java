package com.java.tao.gaode.service;

import java.util.List;

public interface MatrixService {

    List<String> matrix(List<String> lats, List<String> lons, Integer rows, String name);

    List<String> matrix2(List<String> lats, List<String> lons, Integer rows, String name);
}
