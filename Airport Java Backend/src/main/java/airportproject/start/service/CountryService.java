package airportproject.start.service;

import airportproject.start.entity.Country;
import airportproject.start.repo.CountryRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CountryService {

    @Autowired
    CountryRepo countryRepository;

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    public Optional<Country> findCountryById(Long countryId){
        return countryRepository.findById(countryId);
    }
    public Country create(Country country){
        return countryRepository.save(country);
    }
    public Country update(Country country){
        return countryRepository.save(country);
    }

}
