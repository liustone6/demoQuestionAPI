package com.hellouniverse.demo.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoteRequest {
    private String userName; 
    private int votingScore; // can be +/- to support upvote and downvote
}
