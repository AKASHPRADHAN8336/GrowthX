package com.example.growthX.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Builder
@Accessors(chain = true)
@Document(collection = "assignments")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Assignment {
    @Id
    private String id;
    @Indexed(unique = true)
    @NonNull
    private String userId;
    @NonNull
    private String task;
    @Indexed(unique = true)
    @NonNull
    private String adminId;
    @NonNull
    private String status;
    private LocalDateTime timestamp;
}