package io.hhplus.tdd.point;

import io.hhplus.tdd.database.UserPointTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPointService {

    private final UserPointTable userPointTable;

    public UserPoint chargePoint(long id, long amount) {
        UserPoint userPoint = userPointTable.selectById(id);
        UserPoint updatedPoint = userPoint.addPoint(amount);
        return userPointTable.insertOrUpdate(userPoint.id(), updatedPoint.point());
    }

    public UserPoint getUserPointById(long id) {
        return userPointTable.selectById(id);
    }

    public UserPoint usePoint(long id, long amount) {
        UserPoint userPoint = userPointTable.selectById(id);
        UserPoint updatedPoint = userPoint.usePoint(amount);
        return userPointTable.insertOrUpdate(userPoint.id(), updatedPoint.point());
    }
}
