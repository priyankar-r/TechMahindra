import { Box, SimpleGrid, Card, CardBody, Image, Text, Button, Spinner, useColorMode } from "@chakra-ui/react";
import { useEffect, useState } from "react";
const API_KEY = "841b1e57b8644da284f69b430d6ed00e";
interface Game {
  id: number;
  name: string;
  background_image: string;
  released: string;
  genres: { name: string }[];
}
interface GameCardProps {
  searchQuery: string;
}
function gamecard({ searchQuery }: GameCardProps) {
  const { colorMode } = useColorMode();
  const [games, setGames] = useState<Game[]>([]);
  const [loading, setLoading] = useState(true);
  const [page, setPage] = useState(1);
  const fetchGames = (query = "", pageNum = 1) => {
    setLoading(true);
    const searchParam = query ? `&search=${query}` : "";
    fetch(`https://api.rawg.io/api/games?key=${API_KEY}&page=${pageNum}&page_size=8${searchParam}`)
      .then((response) => response.json())
      .then((data) => {
        setGames(data.results);
        setLoading(false);
      })
      .catch((error) => console.error("Error fetching data:", error));
  };
  useEffect(() => {
    fetchGames(searchQuery, page);
  }, [page, searchQuery]);
  return (
    <Box p={5} bg={colorMode === "dark" ? "gray.900" : "gray.100"}>
      {loading ? (
        <Spinner size="xl" color={colorMode === "dark" ? "white" : "black"} />
      ) : (
        <SimpleGrid columns={[1, 2, 2, 4]} spacing={5}>
          {games.map((game) => (
            <Card
              key={game.id}
              borderRadius="lg"
              overflow="hidden"
              boxShadow="lg"
              bg={colorMode === "dark" ? "gray.800" : "white"}
              color={colorMode === "dark" ? "white" : "black"}
              _hover={{ transform: "scale(1.05)", transition: "0.3s", boxShadow: "0px 0px 15px cyan" }}
            >
              <Image src={game.background_image} objectFit="cover" height="200px" width="100%" />
              <CardBody p={4}>
                <Text fontSize="lg" fontWeight="bold">{game.name}</Text>
                <Text fontSize="xs" color="gray.400" mt={2}>Released: {game.released}</Text>
                <Text fontSize="sm" color="blue.600">{game.genres.map((g) => g.name).join(", ")}</Text>
                <Button size="sm" colorScheme="blue" mt={3}>View Details</Button>
              </CardBody>
            </Card>
          ))}
        </SimpleGrid>
      )}
      <Box mt={5} display="flex" justifyContent="center">
        <Button colorScheme="gray" mr={2} onClick={() => setPage((p) => Math.max(p - 1, 1))} disabled={page === 1}>Previous</Button>
        <Button colorScheme="gray" onClick={() => setPage((p) => p + 1)}>Next</Button>
      </Box>
    </Box>
  );
}
export default gamecard;