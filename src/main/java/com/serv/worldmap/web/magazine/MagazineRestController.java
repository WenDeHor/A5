package com.serv.worldmap.web.magazine;

import com.serv.worldmap.model.Magazine;
import com.serv.worldmap.web.SecurityUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.serv.worldmap.util.ValidationUtil.assureIdConsistent;
import static com.serv.worldmap.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = MagazineRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MagazineRestController extends AbstractMagazineController {

    static final String REST_URL = "/rest/profile/magazines";

    @Override
    @GetMapping("/{id}")
    public Magazine get(@PathVariable int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        super.delete(id);
    }

    @Override
    @GetMapping
    public List<Magazine> getAll() {
        return super.getAll();
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Magazine magazine, @PathVariable int id) {
        super.update(magazine, id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Magazine> createMagazine(@RequestBody Magazine magazine) {
        final Magazine created = super.create(magazine);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL+"/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}
