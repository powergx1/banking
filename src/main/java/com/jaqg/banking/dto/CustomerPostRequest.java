package com.jaqg.banking.dto;

import java.util.List;

public record CustomerPostRequest(Long id, String fullName, List<Long> accounts) {
}