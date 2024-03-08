package com.zehraarslan.homework2.mapper;

import com.zehraarslan.homework2.dto.OrderDto;
import com.zehraarslan.homework2.entity.Order;
import com.zehraarslan.homework2.request.OrderSaveRequest;
import com.zehraarslan.homework2.service.CompanyService;
import com.zehraarslan.homework2.service.CustomerService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order convertToOrder(OrderSaveRequest request);
    OrderDto convertToOrderDto(Order order);
    List<OrderDto> convertToOrderDtos(List<Order> orders);
    List<Order> convertToOrders(List<OrderSaveRequest> orderSaveRequests);
}
