package io.altar.jseproject.business;

import io.altar.jseproject.models.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;

public interface ShelfBusinessInterface extends BusinessInterface <Shelf>{

	public ShelfRepository DBS = ShelfRepository.getInstance();
}
