package com.example.growthX.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Accessors(chain = true)
@Document(collection = "admin")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Admin {
    @Id
    private String id;
    @Indexed(unique = true)
    @NonNull
    private String username;
    @Indexed(unique = true)
    @NonNull
    private String password;

}
