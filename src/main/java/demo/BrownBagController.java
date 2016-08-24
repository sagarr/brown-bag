package demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BrownBagController {

    final BrownBagRepository repo;

    public BrownBagController(final BrownBagRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/api/brownbags")
    public @ResponseBody Iterable<BrownBag> getAllBrownBags() {
        return repo.findAll();
    }
}
