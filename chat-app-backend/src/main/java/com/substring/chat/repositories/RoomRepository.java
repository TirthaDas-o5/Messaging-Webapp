package com.substring.chat.repositories;

import com.substring.chat.entities.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room,String>{
    // get room using room id
    Room findByRoomId(String roomID);
    // we will use repository directly in our controller

}
