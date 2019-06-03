package com.hibernatemapping.repository;

import java.util.List;

import com.hibernatemapping.model.UserDetails;
import com.hibernatemapping.model.UserHistory;

public interface UserHistoryRepositoryCustom {
public List<UserHistory> getUserHistory(UserDetails userID);
}
