package ma.emsipfa.planetdentist.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BaseInterfaceRest<T> {

    ResponseEntity<List<T>> getAll();

    ResponseEntity<T> getById(@PathVariable Long id);

    ResponseEntity<T> save(@RequestBody T baseEntity);

    ResponseEntity<T> update(@PathVariable Long id, @RequestBody T baseEntity);

    ResponseEntity<Object> delete(@PathVariable Long id);

}
