package com.selimhorri.app.service;

import java.util.List;

import com.selimhorri.app.domain.id.FavouriteId;
import com.selimhorri.app.dto.FavouriteDto;
import org.springframework.data.domain.Pageable;

public interface FavouriteService {
	
	List<FavouriteDto> findAll(Pageable pageable);
	FavouriteDto findById(final FavouriteId favouriteId);
	FavouriteDto save(final FavouriteDto favouriteDto);
	FavouriteDto update(final FavouriteDto favouriteDto);
	void deleteById(final FavouriteId favouriteId);
	
}
