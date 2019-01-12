package com.rent.service;

import com.rent.entity.RentInformation;

import java.util.List;
import java.util.Map;

public interface RentInformationService {
    //插入
    public Map<String,Object> insertRentInformation(RentInformation record);

    //在已知求租信息标识的情况下，删除房屋信息
    public Map<String,Object> deleteRentInformation(Integer rentId);

    //在已知求租信息标识的情况下，更新房屋信息
    public Map<String,Object> updateRentInformation(RentInformation record);

    //在已知求租信息标识的情况下，查找
    public RentInformation selectRentInformationById(Integer rentId);

    //查找求租信息的个数
    public int queryRentInformationNum(Map<String,List> map);

    //查找求租信息，从start项到end项，从0开始
    public List<RentInformation> queryRentInformation(Map<String,List> map, int start, int end);

}
