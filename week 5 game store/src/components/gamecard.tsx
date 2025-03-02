import { Box, SimpleGrid, Card, CardBody, Image, Text, Button, Link, Spinner } from '@chakra-ui/react';
import { useEffect, useState } from 'react';
const API_KEY = "841b1e57b8644da284f69b430d6ed00e";
interface Game {
  id: number;
  name: string;
  background_image: string;
  released: string;
  genres: { name: string }[];
}
function gamecard() {
  const [games, setGames] = useState<Game[]>([]);
  const [loading, setLoading] = useState(true);
  const [page, setPage] = useState(1);
  useEffect(() => {
    fetch(`https://api.rawg.io/api/games?key=${API_KEY}&page=${page}&page_size=8`)
      .then((response) => response.json())
      .then((data) => {
        setGames(data.results);
        setLoading(false);
      })
      .catch((error) => console.error("Error fetching data:", error));
  }, [page]);
  return (
    <Box p={5}>
      {loading ? (
        <Spinner size="xl" />
      ) : (
        <SimpleGrid columns={[1, 2, 2, 4]} spacing={5}>
          {games.map((game) => (
            <Card key={game.id} borderRadius="lg" overflow="hidden" boxShadow="md">
              <Image src={game.background_image} objectFit="cover" height="200px" width="100%" />
              <CardBody p={4}>
                <Text fontSize="lg" fontFamily={'monospace'} fontWeight="bold">{game.name}</Text>
                <Text fontSize="xs" fontFamily={'monospace'} color="gray.500" mt={2}>Released: {game.released}</Text>
                <Text fontSize="sm" fontFamily={'monospace'} color="blue.500">{game.genres.map((g) => g.name).join(", ")}</Text>
                <Button size="sm" fontFamily={'monospace'} colorScheme="cyan" mt={3}>View Details</Button>
              </CardBody>
            </Card>
          ))}
        </SimpleGrid>
      )}
      <Box mt={5} display="flex" justifyContent="center">
        <Button fontFamily={'monospace'} colorScheme="teal" mr={2} onClick={() => setPage((p) => Math.max(p - 1, 1))} disabled={page === 1}>
          Previous
        </Button>
        <Button fontFamily={'monospace'} colorScheme="teal" onClick={() => setPage((p) => p + 1)}>Next</Button>
      </Box>
    </Box>
  );
}
export default gamecard;