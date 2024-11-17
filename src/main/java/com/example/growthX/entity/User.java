package com.example.growthX.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Accessors(chain = true)
@Document(collection = "users")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class User {
    @Id
    private String id;
    @Indexed(unique = true)
    @NonNull
    private String username;
    @NonNull
    @Indexed(unique = true)
    private String password;
}
