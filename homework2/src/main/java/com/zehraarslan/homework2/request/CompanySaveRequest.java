package com.zehraarslan.homework2.request;

public record CompanySaveRequest(String name,
                                 String sector,
                                 String email,
                                 String number,
                                 String address) {
}
