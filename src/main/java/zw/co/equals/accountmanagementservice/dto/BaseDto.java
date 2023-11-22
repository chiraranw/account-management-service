package zw.co.equals.accountmanagementservice.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class BaseDto {
    private Long id;
    private LocalTime createdOn = LocalTime.now();
    private LocalTime lastModifiedOn = LocalTime.now();
}
