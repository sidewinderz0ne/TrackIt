package co.id.srs.trackit.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RunDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrack(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM tracking_table ORDER BY timestamp DESC")
    fun getAllTracksSortedByDate(): LiveData<List<Run>>

    @Query("SELECT * FROM tracking_table ORDER BY timeInMillis DESC")
    fun getAllTracksSortedByTimeInMillis(): LiveData<List<Run>>

    @Query("SELECT * FROM tracking_table ORDER BY caloriesBurned DESC")
    fun getAllTracksSortedByCaloriesBurned(): LiveData<List<Run>>

    @Query("SELECT * FROM tracking_table ORDER BY avgSpeedKMH DESC")
    fun getAllTracksSortedByAvgSpeed(): LiveData<List<Run>>

    @Query("SELECT * FROM tracking_table ORDER BY distanceInM DESC")
    fun getAllTracksSortedByDistance(): LiveData<List<Run>>


    @Query("SELECT SUM(timeInMillis) FROM tracking_table")
    fun getTotalTimeInMillis():LiveData<Long>

    @Query("SELECT SUM(caloriesBurned) FROM tracking_table")
    fun getTotalCaloriesBurned():LiveData<Int>

    @Query("SELECT SUM(distanceInM) FROM tracking_table")
    fun getTotalDistanceInM():LiveData<Int>

    @Query("SELECT AVG(avgSpeedKMH) FROM tracking_table")
    fun getTotalAvgSpeedKMH():LiveData<Float>
}